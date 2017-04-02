data=imread('C:\Users\HP\Downloads\lena.tif');
data=im2double(data);

% Filter takes double the size of mask
masksize=3;

% Order of the filter
Q=2;
sumn=[];
sumd=[];
pixln=0;
pixld=0;
[ro col]=size(data);

%% Main Module for Contra Harmonic Mean Filter
for i=1:ro;
    for j=1:col;
        for m=-masksize:masksize;
            for n=-masksize:masksize;
                if (i+m>0 && i+m<ro && j+n>0 && j+n<col && ...      % To keep indices in limit
                        masksize+m>0 && masksize+m<ro && ...
                        masksize+n>0 && masksize+n<col) 
                    
                    pixl1=(data(i+m,j+n)).^(Q+1);                   % Application of Formula
                    pixl2= (data(i+m,j+n)).^Q;
                    pixln=pixln+pixl1;                              % Application of Summation
                    pixld=pixld+pixl2;
                
                end
            end
        end
       reformedimage(i,j)=(pixln/pixld);
       pixln=0;
       pixld=0;
    end
end

figure,imshow(reformedimage)