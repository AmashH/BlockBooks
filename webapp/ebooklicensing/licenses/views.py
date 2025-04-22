
from django.http import HttpResponse

from django.shortcuts import render
from .models import FakeLicense
from django.contrib.auth.decorators import login_required
import requests 

@login_required
def my_licenses(request):
    user_id=request.user.username # .username is used as ownerid in chaincode
    
    known_license_ids= ['LIC001', 'LIC002'] #licenses made with manual invokes on test network to start
    
    licenses = [] 
    for license_id in known_license_ids:
        res = requests.get(f"http://localhost:8080/api/licenses/{license_id}")  #acess api controller endpoint
        if res.ok(): #if api connection succeeds
            data = res.json().get("data") #pulls actual license JSON returned
            if data:
                licenses.append(data) #adds to list so that it can be passed to the template
                
    return render(request, "my_licenses.html", {"licenses": licenses})            

@login_required
def transfer_license_view(request):
    licenses = FakeLicense.objects.filter(owner=request.user)
    message = None
    
    if request.method == 'POST':
        license_id = request.POST.get('license_id')
        new_owner = request.POST.get('new_owner')
        
        # Placeholder logic for now
        message = f"Simulated transfer of license {license_id} to user {new_owner}."

    return render(request, 'transfer_licenses.html', {
        'licenses': licenses,
        'message': message})
