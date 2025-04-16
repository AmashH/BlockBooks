from django.urls import path
from . import views

urlpatterns = [
    path('', views.my_licenses, name='licensing')
]