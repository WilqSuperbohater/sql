#/bin/sh

name=$( echo ${1/'https://'/} | tr / .)
mkdir -p $name
cd $name
touch $name
lynx -dump $1 > $name
git init
git add .
git commit -m "Kucharz kucharz nie oszukasz"

while true; do
    sleep $2
    touch tmp
    lynx -dump $1 > tmp

    n=$(diff -q tmp $name)
    if [ -n "$n" ]; then
        touch difference
        echo 'Site has been changed!' > difference
        diff tmp $name >> difference
        xmessage -center -file difference
        cp tmp $name
        rm tmp
        rm difference
        git add .
        git commit -m "Ba, ba, ba."
    fi
done
