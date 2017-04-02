
function idealfilter(X,P,type)
s=imread('C:\Users\HP\Downloads\lena.tif');
[M,N]=size(s);
S=fft2(double(s)); % Taking Fourier transform to the input image
      
u=0:(M-1);
v=0:(N-1);
idx=find(u>M/2);
u(idx)=u(idx)-M;
idy=find(v>N/2);
v(idy)=v(idy)-N;
[V,U]=meshgrid(v,u);
if(strcmp(type,'hpf'))
D=sqrt(U.^2+V.^2);
end
if(strcmp(type, 'lpf'))
D=sqrt(U.^2-V.^2);
end
H=double(D<=P);               % Comparing with the cut-off frequency 
G=H.*S;                       % Convolution with the Fourier transformed image
g=real(ifft2(double(G)));     % Inverse Fourier transform
imshow(g,[ ]);                % Displaying output image
end
