from django.db import models

# Create your models here.

class Book(models.Model): 
    book_id = models.CharField(max_length=100, default='Anonymous', unique=True) 
    title = models.CharField(max_length=255, default='Anonymous') 
    author= models.CharField(max_length=255, default='Anonymous')
    description= models.TextField(default='No description provided') 
    cover_url= models.URLField(blank=True)
    
    def __str__(self):
        return self.title
    