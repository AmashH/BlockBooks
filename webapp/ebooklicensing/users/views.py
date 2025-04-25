import requests
from django.contrib.auth.decorators import login_required
from django.shortcuts import render

@login_required
def profile_view(request):
    user_id = request.user.username
    try:
        response = requests.get(f'http://localhost:8080/api/licenses/user/{user_id}')
        response.raise_for_status()
        licenses = response.json()
    except requests.RequestException:
        licenses = []  # Fallback in case of API failure

    return render(request, 'profile.html', {'licenses': licenses})
