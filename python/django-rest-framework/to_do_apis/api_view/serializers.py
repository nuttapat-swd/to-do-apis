from rest_framework import serializers

from api_view.models import Tag


class TagSerializer(serializers.ModelSerializer):

    class Meta:
        model = Tag
        fields = ['id', 'title', 'color']
