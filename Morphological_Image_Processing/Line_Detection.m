im = imread('C:\Users\HP\Downloads\lena.jpg');
im=rgb2gray(im);
tol = 20;
[~,ang] = imgradient(im);
out = (ang >= 45 - tol & ang <= 45 + tol) | (ang >= -135 - tol & ang <= -135 + tol)|(ang >= 135 - tol & ang <= 135 + tol) | (ang >= -45 - tol & ang <= -45 + tol)|(ang >= 180 - tol | ang <= -180 + tol);
out_filter = bwareaopen(out, 50);
imshowpair(im,out_filter,'montage');