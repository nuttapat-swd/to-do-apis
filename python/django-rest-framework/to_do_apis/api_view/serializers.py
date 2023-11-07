from rest_framework import serializers

from api_view.models import Tag, Task


class TagSerializer(serializers.ModelSerializer):

    class Meta:
        model = Tag
        fields = ['id', 'title', 'color']

class TaskSerializer(serializers.ModelSerializer):

    def to_representation(self, instance):
        
        return {**super().to_representation(instance),
                'tags_list': TagSerializer(instance.tags_list, many=True).data}

    class Meta:
        model = Task
        fields = '__all__'
