#bin/sh

wget -q -O cat https://api.thecatapi.com/v1/images/search?format=src

img2txt cat

n=$(curl -R -s http://api.icndb.com/jokes/random | jq '.' | grep joke | awk -F '"' '{print $4}')
echo "${n//'&quot;'/'"'}"

rm cat
