from os import system, waitpid, sys
from selenium import webdriver
def openPage(s):
    
    # Taking input from user
    search_string = s
    print("made it here " + s)
    # This is done to structure the string 
    # into search url.(This can be ignored)
    search_string = search_string.replace(' ', '+') 
    
    # Assigning the browser variable with chromedriver of Chrome.
    # Any other browser and its respective webdriver 
    # like geckodriver for Mozilla Firefox can be used
    browser = webdriver.Firefox()
    
    browser.get("https://www.google.com/search?q=" + search_string)


openPage(' '.join(sys.argv[1:]))