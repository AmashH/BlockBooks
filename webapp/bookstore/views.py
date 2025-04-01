import subprocess
import json
from django.shortcuts import render, redirect
from django.contrib import messages

# Mock list of books (hardcoded for simplicity)
MOCK_BOOKS = [
    {"id": "book1", "title": "The Great Gatsby", "price": 9.99},
    {"id": "book2", "title": "To Kill a Mockingbird", "price": 7.99},
    {"id": "book3", "title": "1984", "price": 8.99},
    {"id": "book4", "title": "Pride and Prejudice", "price": 6.99},
    {"id": "book5", "title": "The Catcher in the Rye", "price": 5.99},
]

# Hardcoded user ID for simplicity (no authentication in MVP)
USER_ID = "user456"

def shop(request):
    return render(request, 'bookstore/shop.html', {'books': MOCK_BOOKS})

def buy_book(request, book_id):
    # Find the book by ID
    book = next((b for b in MOCK_BOOKS if b['id'] == book_id), None)
    if not book:
        messages.error(request, "Book not found!")
        return redirect('shop')

    try:
        # Call the Java client to issue a license
        # Assumes the Spring Boot JAR is in the project root as 'fabric-client.jar'
        result = subprocess.run(
            ['java', '-jar', '../fabric-client.jar', 'issue', book_id, USER_ID],
            capture_output=True,
            text=True
        )
        license_id = result.stdout.strip()

        if result.returncode == 0 and license_id.startswith("LIC_"):
            messages.success(request, f"Successfully purchased {book['title']}! License ID: {license_id}")
        else:
            messages.error(request, "Failed to purchase book. Please try again.")
    except Exception as e:
        messages.error(request, f"Error purchasing book: {str(e)}")

    return redirect('shop')

def profile(request):
    licenses = []
    try:
        # Call the Java client to query licenses
        # We'll query each license ID; in a real app, you'd store license IDs per user
        for i in range(1, 100):  # Try a range of license IDs (simplified for demo)
            result = subprocess.run(
                ['java', '-jar', '../fabric-client.jar', 'query', f"LIC_{i}"],
                capture_output=True,
                text=True
            )
            if result.returncode == 0 and result.stdout:
                try:
                    license_data = json.loads(result.stdout.strip())
                    # Match the book ID with our mock books
                    book = next((b for b in MOCK_BOOKS if b['id'] == license_data.get('bookId')), None)
                    if book:
                        license_data['title'] = book['title']
                        licenses.append(license_data)
                except json.JSONDecodeError:
                    continue  # Skip invalid JSON responses
    except Exception as e:
        messages.error(request, f"Error querying licenses: {str(e)}")

    return render(request, 'bookstore/profile.html', {'licenses': licenses})