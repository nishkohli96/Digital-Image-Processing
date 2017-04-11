I = imread('C:\Users\HP\Downloads\circles.png');
se = strel('disk',10);
IM2=imopen(I,se);
IM3=imclose(I,se);
imshowpair(IM2,IM3,'montage');