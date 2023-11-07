from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status

from api_view.models import Tag, Task
from api_view.serializers import TagSerializer, TaskSerializer


class TagApiView(APIView):
    """
    View for tag endpoints
    """
    def post(self, *args, **kwargs):
        title = self.request.data.get('title', None)
        color = self.request.data.get('color', '#FFFFFF')
        if title:
            tag = Tag.objects.create(title=title, color=color)
        else:
            return Response({'error': 'Title must be not None.'}, status=status.HTTP_400_BAD_REQUEST)
        return Response(TagSerializer(tag).data, status=status.HTTP_201_CREATED)
    
    def get(self, *args, **kwargs):
        tags = Tag.objects.all()
        tags_data = TagSerializer(tags, many=True).data
        return Response(tags_data, status=status.HTTP_200_OK)

class TagDetailApiView(APIView):

    def get(self, request, pk):
        tag = Tag.objects.filter(pk=pk).first()
        if tag is None:
            return Response({'error': 'Tag not found.'}, status=status.HTTP_404_NOT_FOUND)
        return Response(TagSerializer(tag).data)
    
    def patch(self, request, pk, **kwargs):
        tag = Tag.objects.filter(pk=pk).first()
        if tag is None:
            return Response({'error': 'Tag not found.'}, status=status.HTTP_404_NOT_FOUND)
        else:
            tag = TagSerializer(tag, data=request.data)
            tag.is_valid(raise_exception=True)
            tag.save()
            return Response(tag.data)
    
    def delete(self, request, pk, **kwargs):
        tag = Tag.objects.filter(pk=pk).first()
        if tag is None:
            return Response({'error': 'Tag not found.'}, status=status.HTTP_404_NOT_FOUND)
        else:
            tag.delete()
            return Response(status=status.HTTP_204_NO_CONTENT)

class TaskListAPIView(APIView):
    """
    View for tasks create, list
    """
    def post(self, request, **kwargs):
        task_ser = TaskSerializer(data=request.data)
        task_ser.is_valid(raise_exception=True)
        task_ser.save()
        return Response(task_ser.data)
    
    def get(self, request, **kwargs):
        all_tasks = Task.objects.all()
        tasks_data = TaskSerializer(all_tasks, many=True).data
        return Response(tasks_data, status=status.HTTP_200_OK)

class TaskDetailAPIView(APIView):
    def get(self, request, pk, **kwargs):
        task = Task.objects.filter(pk=pk).first()
        if task is None:
            return Response({'error': 'Tag not found.'}, status=status.HTTP_404_NOT_FOUND)
        return Response(TaskSerializer(task).data)

    def patch(self, request, pk, **kwargs):
        task = Task.objects.filter(pk=pk).first()
        if task is None:
            return Response({'error': 'Tag not found.'}, status=status.HTTP_404_NOT_FOUND)
        else:
            task = TaskSerializer(task, data=request.data)
            task.is_valid(raise_exception=True)
            task.save()
            return Response(task.data)
    
    def delete(self, request, pk, **kwargs):
        task = Task.objects.filter(pk=pk).first()
        if task is None:
            return Response({'error': 'Tag not found.'}, status=status.HTTP_404_NOT_FOUND)
        else:
            task.delete()
            return Response(status=status.HTTP_204_NO_CONTENT)
