from os import system
from selenium import webdriver

# Taking input from user
search_string = system.argv[1]
  
# This is done to structure the string 
# into search url.(This can be ignored)
search_string = search_string.replace(' ', '+') 
  
# Assigning the browser variable with chromedriver of Chrome.
# Any other browser and its respective webdriver 
# like geckodriver for Mozilla Firefox can be used
browser = webdriver.Chrome('chromedriver')
  
browser.get("https://www.google.com/search?q=" + search_string)
                                     