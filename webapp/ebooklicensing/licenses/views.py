
from django.http import HttpResponse

from django.shortcuts import render
from .models import FakeLicense
from django.contrib.auth.decorators import login_required

@login_required
def my_licenses(request):
    licenses = FakeLicense.objects.filter(owner=request.user)
    return render(request, 'my_licenses.html', {'licenses': licenses})

@login_required
def transfer_license_view(request):
    message = None
    if request.method == 'POST':
        license_id = request.POST.get('license_id')
        new_owner = request.POST.get('new_owner')
        
        # Placeholder logic for now
        message = f"Simulated transfer of license '{license_id}' to user '{new_owner}'."

    return render(request, 'transfer_license.html', {'message': message})
