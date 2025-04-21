from django.contrib.auth.decorators import login_required
from django.shortcuts import render
from licenses.models import FakeLicense 

@login_required
def profile_view(request):
    licenses = FakeLicense.objects.filter(owner=request.user)
    return render(request, 'profile.html', {'licenses': licenses})
