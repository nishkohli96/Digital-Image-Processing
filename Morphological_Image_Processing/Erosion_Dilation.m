I = imread('C:\Users\HP\Downloads\circles.png');
se = strel('disk',10);
IM2=imerode(I,se);
IM3=imdilate(I,se);
imshowpair(IM2,IM3,'montage');