function ButterWorth(grade, cutoff_freq, img_name,type)

img=imread('C:\Users\HP\Downloads\lena.tif'); %read image
[rows,cols] = size(img);
img_double=double(img);
FImg = fftshift(fft2(img_double)); %Fast Fourier transform 2D and shift it to Center 

% compute distance to center with consider image size
x =  (ones(rows,1) * [1:cols]  - (fix(cols/2)+1))/cols;
y =  ([1:rows]' * ones(1,cols) - (fix(rows/2)+1))/rows;

radius = sqrt(x.^2 + y.^2); 
% create filter
Filter = 1 ./ (1.0 + (radius ./ cutoff_freq).^(2*grade));
% change filter type low pass or high
if(strcmp(type, 'hpf'))
    Filter = 1 - Filter;
end
figure;
surf([-1:2/(cols-1):1],[-1:2/(rows-1):1], Filter);
shading interp;
title('Butterworth filter');
xlabel('x');
ylabel('y');
zlabel('intensity');
grid on;

%applay filter
resultFImg = FImg .* Filter;

resultImg = real(ifft2(ifftshift(resultFImg)));

%show image
figure;
subplot(1,2,1); imshow(img); title('Orginal Image')
subplot(1,2,2); imshow(resultImg,[]); title('Filtered Image')