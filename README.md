# ResevationSystem_RahulYadav_20-7-2024


Currently there is 6 bus in the System with given route

Bus1 = Ahmadabad,Amreli,Bharuch,Bhavnagar,Bhuj,Dwarka
Bus2 = Gandhinagar,Godhra,Jamnagar,Junagadh,Kandla,Khambhat
Bus3 = Kheda,Mahesana,Morbi,Nadiad,Navsari,Okha
Bus4 = Palanpur,Patan,Porbandar,Rajkot,Surat,Surendranagar
Bus5 = Ambala,Bhiwani,Chandigarh,Faridabad,Gurugram,Hansi
Bus6 = China,Amreli,India,USA,Bhuj,Dubal

Curl command :-  
Search Module
Search between cities
curl --location 'localhost:8080/api/search?from=Amreli&to=USA' \
--header 'Cookie: JSESSIONID=7DF9AA80F8EBEC99EC1085C2CCD27A25'

Available seats for given busid
Available seats module
curl --location 'localhost:8080/api/empty/seat?busId=101' \
--header 'Cookie: JSESSIONID=7DF9AA80F8EBEC99EC1085C2CCD27A25'

Booking Api
Booking Module
curl --location --request POST 'localhost:8080/API/Booking/book?userId=100&busId=101&totalSeatToBook=2' \
--header 'Cookie: JSESSIONID=7DF9AA80F8EBEC99EC1085C2CCD27A25'

Booking with respect to user
curl --location 'localhost:8080/API/Booking/all/user?userId=101' \
--header 'Cookie: JSESSIONID=7DF9AA80F8EBEC99EC1085C2CCD27A25'

All Booking
curl --location 'localhost:8080/API/Booking/all/booking' \
--header 'Cookie: JSESSIONID=7DF9AA80F8EBEC99EC1085C2CCD27A25'
