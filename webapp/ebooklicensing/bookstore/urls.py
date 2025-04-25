from django.urls import path
from . import views
from .views import book_list, issue_license_view


urlpatterns = [
    path('', views.book_list, name='book_list'),
    path('buy/<str:book_id>/', issue_license_view, name='issue_license')

]
