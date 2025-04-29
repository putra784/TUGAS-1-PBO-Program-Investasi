# PBO-Project 1

# Identitas kami
```
Nama  : I Gede Puterayasa
NIM   : 2405551088
Kelas : PBO E

Nama  : I Wayan Arya Wikananda
NIM   : 2405551090
Kelas : PBO E
```


# Program Investasi Sederhana
Hi semua! Ini merupakan sebuah project program investasi sederhana untuk menyelesaikan tugas 1 dengan bahasa Java pada matakuliah PBO kami.

Program ini dibuat untuk dua role user dengan kepemilikan akses yang berbeda, yaitu:
1. Admin akan diberikan akses untuk menambahkan saham dan mengubah harga saham pada menu saham, serta menambah SBN pada menu SBN.
2. Customer akan diberikan akses untuk membeli saham, menjual saham, membeli SBN, simulasi SBN, dan melihat portofolio yang mereka miliki.

Selain itu, program ini juga dilengkapi dengan beberapa validasi, seperti:
1. Typo atau ketidaksesuaian input pada role
2. Typo atau ketidaksesuaian username dengan role yang dipilih
3. Ketidaksesuaian password dengan username yang dipakai
4. Ketidaksesuaian input integer
5. Ketidaksesuaian input dengan ketentuan tertentu
6. Validasi pengulangan program

Berikut adalah deskripsi program, penjelasan apa yang terjadi pada program, beserta diagram UML dari program ini. Untuk deskripsi kode yang lebih lengkap dapat dilihat pada kode program yang sudah di commit oleh kami sebelumnya (sudah disertakan comment untuk membantu mengertikan jalan kerja setiap class atau method). Selamat menyimak.

# UML
![UML PBO TUGAS 1](https://github.com/user-attachments/assets/0563fccb-5114-4724-926e-c994b83639c6)



# Bagaimana Program ini Dapat Berjalan?
Program ini di jalankan dengan menerapkan konsep dasar dari Object Oriented Programming (OOP), yaitu:
1. Penggunaan class, object, dan constructor, acces modifier, Encapsulation, dan this keyword.
2. Penggunaan flow control seperti while loop, for each loop, if-else, dan switch-case.
3. Penggunaan ArrayLists dan HashMap

# Penjelasan Penggunaan Program
DIbawah ini merupakan penggunaan program investasi sederhana beserta hasil screenshoot tiap bagian.

# Tampilan Awal Menu Login Page
![Screenshot 2025-04-29 113411](https://github.com/user-attachments/assets/ee9e6fa7-9f58-4f9d-8ec9-4fafca240469)
![Screenshot 2025-04-29 115029](https://github.com/user-attachments/assets/72e4b8be-7e47-44f9-ae2f-1bd130025376)

Setelah melakukan login dan berhasil sebagai customer atau admin, maka program akan menampilkan login berhasil sebagai customer atau admin serta langsung masuk pada menu utama bergantung pada role mereka. Dimana, username dan password sudah di hardcode pada program.

Hardcode dari user adalah sebagai berikut:
1. Role : customer
```
* username = Aryawikananda
  password = arya321
* username = Eriwidura
  password = eri333
```

2. Role : admin
```
* username = Puterayasa
  password = putera123
```

## Validasi Login
![Screenshot 2025-04-29 120237](https://github.com/user-attachments/assets/b9b291b9-17dd-4d9b-ba5c-a7438bd64ff1)

Ketika pengguna typo atau salah memasukkan role, username, atau password, maka mereka akan diminta untuk mengulang input tersebut hingga seluruh input sesuai dengan apa yang diminta.

# Menu Utama Admin
![Screenshot 2025-04-29 122214](https://github.com/user-attachments/assets/dee65ff0-9b22-4aac-9490-d711f54ce6e9)

Setelah login sebagai admin, pengguna akan ditampilkan menu seperti pada gambar, dimana ketika admin memilih '1', program akan masuk ke class Saham, ketika memilih '2', program akan masuk ke class SBN, dan ketika memilih '3', maka admin akan logout.

# Menu Utama Customer
![Screenshot 2025-04-29 090353](https://github.com/user-attachments/assets/e42c153c-f3fb-4484-96e9-4f9d34cbe97b)

Setelah pengguna login sebagai customer, pengguna akan langsung ditampilkan menu seperti gambar diatas. Dimana, terdapat opsi untuk membeli saham, menjual saham, simulasi SBN, menampilkan portofolio, dan logout.

# Validasi Menu Utama
![Screenshot 2025-04-29 123552](https://github.com/user-attachments/assets/ca7a5dbc-83f1-4845-8169-66e7d816a4cd)

Gambar diatas merupakan contoh pengecekan input pengguna, dimana ketika pengguna menginputkan angka diluar opsi yang tersedia (angka lebih dari 6 atau huruf), maka pengguna mendapat pesan input tidak valid dan diminta untuk menginput kembali.

# Menu Sahan Admin

## Tampilan Awal
![Screenshot 2025-04-29 124636](https://github.com/user-attachments/assets/a201adbb-d5eb-41a5-a4fb-7010802507e1)

Setelah admin memilih '1' pada menu utama, maka tampilan selanjutnya akan seperti ini. Dimana, admin dapat menambahkan saham dan mengubah harga saham atau kembali ke menu utama.

### Tampilan Setelah Masuk Ke Menu Tambah Saham
![Screenshot 2025-04-29 125816](https://github.com/user-attachments/assets/5c578725-86e6-48d3-a4a2-510efbcaec23)
![Screenshot 2025-04-29 125837](https://github.com/user-attachments/assets/e9ad5bfc-de20-48f6-be1e-cfbbb0879855)
![Screenshot 2025-04-29 125938](https://github.com/user-attachments/assets/1e045f42-b726-48a1-862a-c515c90c2679)

Setelah masuk ke menu Tambah Saham, admin akan langsung diminta untuk memasukkan kode saham, nama perusahaan, dan harga saham per-lembar dalam rupiah. Nantinya, akan ditampilkan hasil saham yang ada pada daftar saham setelah ditambahkan. Lalu, diakhir admin akan ditanya apakah ingin menambah saham lagi atau kembali ke tampilan awal menu saham.

#### Studi Kasus Validasi Tambah Saham
![Screenshot 2025-04-29 132502](https://github.com/user-attachments/assets/a82d2e03-6486-4ef2-8c06-1b92999bd231)
![Screenshot 2025-04-29 132646](https://github.com/user-attachments/assets/d418f4b2-7d02-439b-b723-575ce4080b08)

Gambar diatas menunjukkan dua studi kasus, dimana ketika kode saham sudah ada pada daftar saham, maka program tidak dapat mengeksekusi dan menampilkan pesan "Kode saham sudah ada! Tidak bisa menambahkan saham yang sama", dan ketika pengguna menginputkan harga selain angka, maka program akan menampilkan pesan "Input harga tidak valid! Silakan ulang kembali." dan program akan meminta input kembali.

### Tampilan Setelah Masuk ke Menu Ubah Harga Saham
![Screenshot 2025-04-29 142411](https://github.com/user-attachments/assets/5f7069cb-81d2-4a29-a4ce-5c6133c60a17)
![Screenshot 2025-04-29 142756](https://github.com/user-attachments/assets/60c7b133-9fff-4b29-ae43-ac841db04460)
![Screenshot 2025-04-29 142812](https://github.com/user-attachments/assets/3e69c487-54fe-4714-a496-0928123c7974)
![Screenshot 2025-04-29 142835](https://github.com/user-attachments/assets/2907be42-5927-4d2c-a7bb-1c8f72477ab0)

Setelah masuk ke menu ubah harga saham, tampilan awalnya akan seperti pada gambar. Dimana, itu merupakan daftar saham yang ada. Admin diminta untuk memasukkan kode saham yang ingin diubah harganya, lalu memasukkan harga baru setelah diubah. Lalu, admin juga ditanya apakah ingin mengubah harga saham lagi atau kembali ke tampilan awal menu saham admin.

#### Studi Kasus Validasi Ubah Harga Saham
![Screenshot 2025-04-29 143339](https://github.com/user-attachments/assets/c9df3ec2-66f5-45df-a25e-6a92a2fdab63)
![Screenshot 2025-04-29 143406](https://github.com/user-attachments/assets/5ee56d30-37a7-40e9-9e41-2ea08d600fed)

Gambar diatas merupakan dua studi kasus yang mirip dengan studi kasus sebelumnya. Ketika kode saham tidak ditemukan dan atau input harga tidak valid, maka admin akan diminta menginputkan ulang.

# Menu SBN Admin

## Tampilan Awal
![Screenshot 2025-04-29 143651](https://github.com/user-attachments/assets/8f2b38f7-dfc5-41ca-8a42-19374d83072e)

Setelah masuk ke menu sbn admin, maka akan muncul tampilan seperti pada gambar, dimana pada bagian ini admin dapat memilih opsi tambah sbn atau kembali ke menu utama.

### Tampilan Setelah Masuk Ke Menu Tambah SBN
![Screenshot 2025-04-29 144721](https://github.com/user-attachments/assets/f6be1f11-6548-4633-8072-da5331d4b03b)
![Screenshot 2025-04-29 144735](https://github.com/user-attachments/assets/cd89e80a-800f-4f50-9f17-a86aec1edb88)
![Screenshot 2025-04-29 144748](https://github.com/user-attachments/assets/6718a2da-79d8-4c4b-b2e4-ead3b4c388bd)

Gambar diatas merupakan tampilan program setelah masuk ke menu tambah SBN. Terlihat pada gambar, bahwa pada awalnya kita diminta untuk menginputkan beberapa data seperti kode SBN, jenis, harga per-unit, bunga tahunan, dan tenor. Setelah itu, program akan langsung menampilkan daftar SBN setelah ditambahkan dan juga menanyakan apakah ingin menambah SBN lagi atau kembali ke tampilan awal menu SBN.

#### Studi Kasus Validasi Tambah SBN
![Screenshot 2025-04-29 150608](https://github.com/user-attachments/assets/9dae8823-51de-4d61-aaaa-8e5f034d93bd)

Gambar tersebut merupaka beberapa validasi yang diterapkan pada menu ini. Diantaranya:
1. ketika admin ingin menambahkan SBN dengan kode yang sama, maka program menampilkan pesan dan meminta admin untuk mengulang input.
2. Ketika admin salah mengetik tahun (tidak bulat atau bukan angka), maka admin akan diminta menginputkan ulang.
3. Ketika pengguna salah menginputkan angka, maka admin meminta input ulang pada bagian tersebut.

# Menu Customer

## Menu Pembelian Saham
* Studi kasus 1 (Membeli saham ANTM 1000 lembar) :
![Screenshot 2025-04-29 152039](https://github.com/user-attachments/assets/11e7cc3e-353c-4555-b735-576c344c8547)
![Screenshot 2025-04-29 152059](https://github.com/user-attachments/assets/f0454123-92b3-4f67-860f-6c3f8b39ee6e)
![Screenshot 2025-04-29 152122](https://github.com/user-attachments/assets/22468c06-d595-497d-80e5-cba623dd07e2)

Setelah memasuki menu beli saham, tampilannya akan seperti pada gambar. Customer diminta untuk menginputkan kode saham yang ingin dibeli dan menginputkan jumlah lembar yang ingin dibeli. Jika berhasil, terdapat pesan "Pembelian saham baru berhasil! Data dapat dicek pada menu portofolio." dan validasi ingin membeli lagi atau kembali ke menu utama customer.
* Studi kasus 2 (Mengulang program dan menambahkan jumlah lembar sebanyak 200 pada kode saham yang sama) :
![Screenshot 2025-04-29 152951](https://github.com/user-attachments/assets/434e5038-5772-4d44-85ad-aae9bff7c117)
![Screenshot 2025-04-29 153009](https://github.com/user-attachments/assets/2b5075a5-be0a-4fbd-8297-1121ecccc186)

Ketika customer ingin membeli saham yang sudah dimiliki, maka total saham tersebut akan dijumlahkan dengan banyak lembar saham yang sudah dibeli pada awal (sebelum mengulang program).

### Validasi Pembelian Saham
![Screenshot 2025-04-29 153350](https://github.com/user-attachments/assets/d5735d3f-9e92-4e74-8b09-55b6b9320364)
![Screenshot 2025-04-29 153315](https://github.com/user-attachments/assets/74229ca2-6363-4b87-81e8-04283f0aced5)

Kedua gambar diatas merupakan dua studi kasus mengenai proses pembelian saham, dimana ketika pengguna menginputkan kode saham yang tidak ada pada daftar saham atau salah menginputkan angka (0 atau huruf), maka program akan menampilkan suatu pesan dan meminta customer menginputkan ulang.

## Menu Penjualan Saham
![Screenshot 2025-04-29 172214](https://github.com/user-attachments/assets/4c24a646-5ef8-44a2-9f39-94e50b6cfb2e)
![Screenshot 2025-04-29 172226](https://github.com/user-attachments/assets/d6b08fff-06ed-43b9-a2fc-3c329ffd78ca)
![Screenshot 2025-04-29 172257](https://github.com/user-attachments/assets/60786099-4ce5-4fd8-8852-1b88f7f821d8)

Setelah masuk ke menu penjualan saham, customer akan ditampilkan daftar saham yang ia miliki, lengkap dengan kode saham, nama perusahaan, jumlah lembar, total investasi, dan harga per-lembar saham. Setelah itu, customer diminta untuk menginputkan kode saham dan jumlah lembar yang ingin dijual. Lalu, ketika customer selesai memasukkan jumlah lembar, program akan menanyakan apakah customer tersebut ingin menjual saham itu lagi atau kembali ke menu awal customer.

### Validasi Penjualan Saham
![Screenshot 2025-04-29 173005](https://github.com/user-attachments/assets/92534357-eb22-48c4-bae0-9ee0c4eee8f8)
![Screenshot 2025-04-29 173021](https://github.com/user-attachments/assets/4096b6aa-f419-4bee-830a-08d113143f12)
![Screenshot 2025-04-29 173036](https://github.com/user-attachments/assets/b6c453f2-ca13-4bf4-9f3c-5744205774f8)

Ketiga gambar diatas merupakan hasil screenshoot studi kasus pada menu penjualan saham, diantaranya :
1. Ketika kode tidak ditemukan, maka program akan meminta mengulan input disaat pengguna menginputkan jumlah lembar yang ingin dijual.
2. Ketika jumlah lembar yang diinputkan = 0, lebih, atau bukan angka, maka program akan meminta mengulang program.

## Menu Pembelian SBN
![Screenshot 2025-04-29 173610](https://github.com/user-attachments/assets/0d8da13e-c97b-43f9-8584-0da703307897)
![Screenshot 2025-04-29 173625](https://github.com/user-attachments/assets/e1686f5b-2970-480d-97b2-f56f0f636a7a)
![Screenshot 2025-04-29 173645](https://github.com/user-attachments/assets/6adb7031-6273-4421-9593-6e8070dca94c)

Setelah masuk ke menu pembelian SBN, maka customer akan dapat melihat daftar SBN yang ada. Setelah itu, customer diminta untuk menginput kode SBN yang ingin dibeli dan juga nominal investasi dengan minimal beli Rp1.000.000,00. Pada bagian akhir, customer juga diminta ingin melanjutkan kembali atau kembali ke menu customer.

### Validasi Pembelian SBN
![Screenshot 2025-04-29 182751](https://github.com/user-attachments/assets/f4bb7721-344c-42e4-a78a-30cc2e572e84)
![Screenshot 2025-04-29 182837](https://github.com/user-attachments/assets/744efe6f-535f-4dd2-a555-7e8480540744)

Kedua gambar tersebut merupakan contoh studi kasus validasi input costumer. Terlihat bahwa ketika kode SBN tidak terdapat pada daftar SBN atau input pada nominal investasi tidak valid, maka program akan langsung menampilkan pesan tertentu dan langsung meminta customer untuk menginputkan ulang bagian tertentu.

## Menu Simulasi SBN
![Screenshot 2025-04-29 183218](https://github.com/user-attachments/assets/350e372d-f796-4a81-8129-64cf4384d7e3)
![Screenshot 2025-04-29 183236](https://github.com/user-attachments/assets/6bd0dcb3-5f86-4475-99c0-166039f566d0)
![Screenshot 2025-04-29 183303](https://github.com/user-attachments/assets/fa81c5f3-babc-4337-a8a9-bcd976c51606)

Setelah masuk menu simulasi SBN, program akan langsung menampilkan daftar SBN yang dapat di simulasikan. Simulasi SBN ini berfungsi untuk menentukan estimasi kupon per-bulan dari suatu SBN. Awalnya, pengguna diminta untuk memasukkan kode SBN yang ingin di simulasikan, lalu nominal investasinya. Setelah itu, program akan langsung menampilkan estimasi kupon yang diterima per-bulan.

### Validasi Simulasi SBN
![Screenshot 2025-04-29 184813](https://github.com/user-attachments/assets/e128938b-1748-49ba-a5e0-ffe5399d18ae)
![Screenshot 2025-04-29 184833](https://github.com/user-attachments/assets/53b4030a-c760-4e7d-942c-2a92bbe9880b)
![Screenshot 2025-04-29 184852](https://github.com/user-attachments/assets/d4c38ce4-8eb5-448e-9cb1-724446b251b6)


