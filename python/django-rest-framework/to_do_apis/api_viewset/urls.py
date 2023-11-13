from rest_framework import routers
from api_viewset.views import TagViewset, TaskViewset 


router = routers.SimpleRouter()
router.register(r'tags', TagViewset)
router.register(r'tasks', TaskViewset)

urlpatterns = []
urlpatterns += router.urls

