f = imread('C:\Users\HP\Downloads\lena.tif');
f = imnoise(f,'gaussian',0,0.01);
f = im2double(f);
subplot(1,2,1),imshow(f),title('Original Image');
[m n]=size(f);
si=1;
for i = 1:m
for j = 1:n 
con=0; s1=1;
for k1 = i-si:i+si
for p1 = j-si:j+si
if ((k1 > 0 && p1 > 0) && (k1 < m && p1 < n ))
con = con+1;
s1=s1*f(k1,p1);
end
end
end
b1(i,j)=s1^(1/con);
end 
end
subplot(1,2,2),imshow(b1),title('Geometric mean filtered');