#Quality of Life Games App File

import grist
from functions import *
import datetime, math, re

@grist.userTable
class Krebsville_heat_map_food_desert:
  STORE_NAME  grist.Text()
    LICENSE_ID  = grist.Numeric()
      ACCOUNT_NUMBER  = grist.Numeric()
      ADDRESS = grist.Text()
      ZIP_CODE = grist.Numeric()
      COMMUNITY_AREA = grist.Numeric()
      WARD = grist.Numeric()
      LATITUDE = grist.Numeric()
      LONGITUDE = grist.Numeric()
      
      
