from django.urls import path
from . import views

urlpatterns = [
    path('', views.shop, name='shop'),  # Shop page
    path('buy/<str:book_id>/', views.buy_book, name='buy_book'),  # Buy a book
    path('profile/', views.profile, name='profile'),  # Profile page
]