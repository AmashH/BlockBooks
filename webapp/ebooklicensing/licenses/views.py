
from django.http import HttpResponse

from django.shortcuts import render
from .models import FakeLicense
from django.contrib.auth.decorators import login_required

@login_required
def my_licenses(request):
    licenses = FakeLicense.objects.filter(owner=request.user)
    return render(request, 'my_licenses.html', {'licenses': licenses})


