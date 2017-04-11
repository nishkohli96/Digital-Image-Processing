I= imread('C:\Users\HP\Downloads\lena.jpg');
level = graythresh(I);
Y=bwmorph(BW,'thicken');
imshow(Y);
