# Generated by Django 3.2.18 on 2023-11-06 15:32

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Tag',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=255)),
                ('color', models.CharField(default='#FFFFFF', max_length=255)),
            ],
        ),
        migrations.CreateModel(
            name='Task',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=255)),
                ('detail', models.TextField()),
                ('is_checked', models.BooleanField(default=False)),
                ('tags_list', models.ManyToManyField(related_name='tags_list_task', to='api_view.Tag')),
            ],
        ),
    ]
