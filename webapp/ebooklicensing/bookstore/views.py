from django.shortcuts import render
from .models import Book
import requests
from django.contrib.auth.decorators import login_required
from django.shortcuts import redirect


def book_list(request):
    books = Book.objects.all()
    return render(request, 'book_list.html', {'books': books})



@login_required
def issue_license_view(request, book_id):
    user_id = request.user.username
    try:
        response = requests.post(
            'http://localhost:8080/api/licenses',
            json={"book_id": book_id, "user_id": user_id},
            timeout=5
        )
        print("Response from Spring Boot:", response.status_code, response.text)

        response.raise_for_status()
    except requests.RequestException as e:
        print(f"License issue failed: {e}")

    return redirect('profile')  # show newly issued license



