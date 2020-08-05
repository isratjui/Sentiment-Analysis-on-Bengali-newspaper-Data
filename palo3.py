import re
import urllib
from BeautifulSoup import *
txt1 = open('test1111_data.txt','a')
c = 1
l = ['firstpage','rokomari','country','capital','world','capitalcity','around-dhaka','editorial','business','lastpage']
for q in l:
	for c in range(1,2):
		if c < 10:
			b = urllib.urlopen('http://www.prothom-alo.com/tp-rokomari/2016-05-01')
			#b = urllib.urlopen('http://www.prothom-alo.com/tp-'+q+'/2016-05-0'+str(c))
		else:
			b = urllib.urlopen('http://archive.prothom-alo.com/home/date/2013-08-01')
			#b = urllib.urlopen('http://www.prothom-alo.com/tp-'+q+'/2016-05-'+str(c))
		data = b.read()
		#print data
		#txt1.write(str(data))
		soup = BeautifulSoup(data)
		#txt1.write(str(soup))
		tags = str(soup)
		#print tags
		
		
		for tag1 in tags:
			#print tag1
			#txt1.write(str(tag1))
			tag = str(tag1)
			#tag = tag.rstrip()
			print tag
			#txt1.write(tag)
			ls = re.findall('(.+?)</span', tag)

			#print ls
			for num in ls:
				num1 = num.split(">")
				print num1[1]
				if c < 10:
					txt1.write(num1[1])
					txt1.write(" ||2016-05-0"+str(c))
					txt1.write("\n")
				else: 
					txt1.write(num1[1])
					txt1.write(" ||2016-05-"+str(c))
					txt1.write("\n")
			
	
		#txt1.write('http://www.thedailystar.net/newspaper?date=2016-10-'+str(c))
		print('http://www.prothom-alo.com/tp-'+q+'/2016-05-0'+str(c))
	break
txt1.close()
