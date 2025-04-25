
from django.http import HttpResponse

from django.shortcuts import render

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
    if request.method == "POST":
        license_id = request.POST.get("license_id")
        new_owner_id= request.POST.get("new_owner_id")  #on the transfer license form, get the inputted values and store
        
        res = requests.put( #sends http put request with dynamically inserted license id
            f"http://localhost:8080/api/licenses/{license_id}/transfer",
            json={"new_owner_id": new_owner_id})  #sends json payload to spring boot API
    
  
        
        if res.ok and res.json().get("success"): #if api call successful and parses json returned from api 
            return redirect("licensing") #redirect to license app if previous is successful 

    return render(request, "transfer_licenses.html") #else if not a post request, return to transfer page 