#/bin/sh

touch myps.txt
touch header.txt
echo "- Name State Pid PPid Files" > header.txt
i=1;
for p in /proc/*/status
do
    pid=$(cat $p | awk 'NR==6' | awk '{ print $2 }')
    count=$(ls /proc/$pid/fd/ | wc -l)
    echo ${i}" "$(cat $p | awk 'NR==1 || NR==3 || NR==6 || NR==7' | awk '{ print $2 }' | tr '\n' ' ')" "$count >> myps.txt
    ((i++))
done

cat header.txt myps.txt | column -t

rm header.txt
rm myps.txt

