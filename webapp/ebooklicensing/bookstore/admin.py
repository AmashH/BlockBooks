from django.contrib import admin

# Register your models here.

from .models import Book

@admin.register(Book)
class BookAdmin(admin.ModelAdmin):
    list_display = ('title', 'author', 'book_id')
    fields = ('book_id', 'title', 'author', 'description', 'cover_url')
