from django.urls import path
from . import views
from .views import transfer_license_view


urlpatterns = [
    path('', views.my_licenses, name='licensing'),
    path('transfer/', transfer_license_view, name='transfer_license')

]