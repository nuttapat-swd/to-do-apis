from django.db import models

# Create your models here.

class Tag(models.Model):
    title = models.CharField(max_length=255, blank=False, null=False)
    color = models.CharField(max_length=255, blank=False, null=False, default='#FFFFFF')

class Task(models.Model):
    title = models.CharField(max_length=255, blank=False, null=False)
    detail = models.TextField()
    is_checked = models.BooleanField(default=False)
    tags_list = models.ManyToManyField(Tag, related_name='tags_list_task')
