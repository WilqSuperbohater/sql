#/bin/sh
for f in *
do
  n=`echo $f | tr [A-Z] [a-z]`
  if [ "$f" != "$n" ]; then
    mv "$f" "$n"
  fi
done
