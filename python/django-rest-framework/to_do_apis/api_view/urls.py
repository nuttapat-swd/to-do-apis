from api_view.views import TagApiView, TagDetailApiView
from django.urls import path, include


urlpatterns = [
    path('tags/', TagApiView.as_view(), name='tags'),
    path('tags/<int:pk>/', TagDetailApiView.as_view(), name='tags-detail'),
]
