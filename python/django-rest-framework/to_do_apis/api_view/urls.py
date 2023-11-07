from api_view.views import TagApiView, TagDetailApiView, TaskListAPIView, TaskDetailAPIView
from django.urls import path, include


urlpatterns = [
    path('tags/', TagApiView.as_view(), name='tags'),
    path('tags/<int:pk>/', TagDetailApiView.as_view(), name='tags-detail'),
    path('tasks/', TaskListAPIView.as_view(), name='tasks-list'),
    path('tasks/<int:pk>/', TaskDetailAPIView.as_view(), name='tasks-detail'),
]
