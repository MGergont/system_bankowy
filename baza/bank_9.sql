-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 18 Sty 2023, 19:58
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `bank_9`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `adres`
--

CREATE TABLE `adres` (
  `id_adres` int(11) NOT NULL,
  `kod_pocztowy` varchar(20) DEFAULT NULL,
  `miejscowosc` varchar(20) DEFAULT NULL,
  `nr_domu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `adres`
--

INSERT INTO `adres` (`id_adres`, `kod_pocztowy`, `miejscowosc`, `nr_domu`) VALUES
(1, '37-750', 'Dubiecko', 203),
(2, '06-200', 'Łomża', 240),
(3, '06-200', 'Łomża', 240),
(4, '86-156', 'Żory', 40),
(5, '90-095', 'Rzeszów', 89),
(6, '79-112', 'Ostrołęka', 88),
(7, '04-443', 'Kraków', 77),
(8, '00-931', 'Rzeszów', 12),
(9, '66-582', 'Gdynia', 11),
(10, '61-610', 'Jaworzno', 14),
(11, '37-750', 'Dubiecko', 222);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `adres_2`
--

CREATE TABLE `adres_2` (
  `id_adres_2` int(11) NOT NULL,
  `kod_pocztowy_2` varchar(20) DEFAULT NULL,
  `miejscowosc_2` varchar(20) DEFAULT NULL,
  `nr_domu_2` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `adres_2`
--

INSERT INTO `adres_2` (`id_adres_2`, `kod_pocztowy_2`, `miejscowosc_2`, `nr_domu_2`) VALUES
(1, '37-750', 'Dubiecko', 203),
(6, '43-526', 'Grudziądz', 14),
(8, '12-345', 'Nienadowa', 321),
(10, '24-521', 'Jastrzębie-Zdrój', 114);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `id_klient` int(11) NOT NULL,
  `imie` varchar(20) DEFAULT NULL,
  `nazwisko` varchar(20) DEFAULT NULL,
  `pesel` varchar(20) DEFAULT NULL,
  `id_kontakt` int(11) DEFAULT NULL,
  `id_adres` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`id_klient`, `imie`, `nazwisko`, `pesel`, `id_kontakt`, `id_adres`) VALUES
(1, 'Mateusz', 'Gergont', '12345', 1, 1),
(2, 'Pola', 'Borkowska', '89092227696', 2, 2),
(3, 'Bąk', 'Borkowski', '48072977305', 3, 3),
(4, 'Bruno', 'Bednarek', '14321320950', 4, 4),
(5, 'Pola', 'Sawicki', '61071453478', 5, 5),
(6, 'Milena', 'Kania', '59120959901', 6, 6),
(7, 'Oliwier', 'Wiśniewski', '94021878951', 7, 7),
(8, 'Florian', 'Lewandowski', '82022219156', 8, 8),
(9, 'Edyta', 'Polak', '86061752821', 9, 9),
(10, 'Leon', 'Zalewski', '68111470712', 10, 10),
(11, 'Jan', 'Kowalski', '12345431', 11, 11);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kontakt`
--

CREATE TABLE `kontakt` (
  `id_kontakt` int(11) NOT NULL,
  `telefon` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `kontakt`
--

INSERT INTO `kontakt` (`id_kontakt`, `telefon`, `email`) VALUES
(1, 123456789, 'mateuszgergont@wp.pl'),
(2, 725487392, 'pola@wp.pl'),
(3, 401408139, 'bak@wp.pl'),
(4, 261155820, 'bruno@gmail.com'),
(5, 826360306, 'sawicki@gmail.com'),
(6, 863310667, 'milena@gmail.com'),
(7, 679168864, 'oliwier@gmail.com'),
(8, 191426373, 'florian@onet.pl'),
(9, 553906423, 'edyta@onet.pl'),
(10, 795202373, 'leon@onet.pl'),
(11, 987654321, '987654321');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konto`
--

CREATE TABLE `konto` (
  `id_konta` int(11) NOT NULL,
  `numer_konta` varchar(30) DEFAULT NULL,
  `stan_konta` double DEFAULT NULL,
  `id_klient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `konto`
--

INSERT INTO `konto` (`id_konta`, `numer_konta`, `stan_konta`, `id_klient`) VALUES
(1, '43194001679058884857953078', 20807.9, 1),
(2, '43194001679058884857953078', 20863, 2),
(3, '45154057067022846175341096', 217, 3),
(4, '23194012520235029208304486', 2015.9, 4),
(5, '25191011943593622210218635', 201656, 5),
(6, '92184066507598829960455912', 2155, 6),
(7, '58167096870289685489343021', 55, 7),
(8, '50161098785743774291679915', 5325.77, 8),
(9, '76167080007755728274441890', 1225, 9),
(10, '32132067056634356402084435', 1115.7, 10),
(11, '30187082042591436557549275', 0, 11);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE `pracownik` (
  `id_pracownik` int(11) NOT NULL,
  `imie` varchar(20) DEFAULT NULL,
  `nazwisko` varchar(20) DEFAULT NULL,
  `login` varchar(20) NOT NULL,
  `haslo` varchar(20) NOT NULL,
  `uprawnienia` int(11) NOT NULL,
  `wyplata` double DEFAULT NULL,
  `id_adres_2` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `pracownik`
--

INSERT INTO `pracownik` (`id_pracownik`, `imie`, `nazwisko`, `login`, `haslo`, `uprawnienia`, `wyplata`, `id_adres_2`) VALUES
(1, 'Alex', 'Kowalska', 'akowalska', '654321', 1, 2830.31, 1),
(6, 'Justyna', 'Polak', '', '', 1, 2835, 6),
(8, 'Mateusz', 'Gergont', 'mgergont', '12345', 2, 1234.34, 8),
(10, 'Mieczysława', 'Kozak', 'mkozak', 'a12345', 2, 2835, 10);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `transakcja`
--

CREATE TABLE `transakcja` (
  `id_transakcja` int(11) NOT NULL,
  `id_nadawca_konto` int(11) DEFAULT NULL,
  `id_odbiorca_konto` int(11) DEFAULT NULL,
  `data_transakcji` date DEFAULT NULL,
  `wartosc_pln` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `transakcja`
--

INSERT INTO `transakcja` (`id_transakcja`, `id_nadawca_konto`, `id_odbiorca_konto`, `data_transakcji`, `wartosc_pln`) VALUES
(1, 1, 4, '2020-11-21', 2830.31),
(2, 1, 4, '2021-11-21', 30.31),
(3, 2, 1, '2021-11-22', 300),
(4, 3, 1, '2021-10-22', 310),
(5, 4, 2, '2021-10-22', 2310),
(6, 10, 9, '2021-01-12', 5310),
(7, 10, 8, '2021-01-12', 5310),
(8, 10, 7, '2021-01-12', 5310),
(9, 10, 6, '2021-01-12', 5310),
(10, 5, 10, '2022-02-02', 10),
(11, 7, 6, '2022-02-03', 20),
(12, 5, 10, '2022-04-22', 140),
(13, 4, 3, '2022-04-13', 210),
(14, 5, 6, '2022-04-22', 140),
(15, 4, 9, '2022-04-13', 210);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `adres`
--
ALTER TABLE `adres`
  ADD PRIMARY KEY (`id_adres`);

--
-- Indeksy dla tabeli `adres_2`
--
ALTER TABLE `adres_2`
  ADD PRIMARY KEY (`id_adres_2`);

--
-- Indeksy dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`id_klient`),
  ADD KEY `PK_id_kontakt` (`id_kontakt`),
  ADD KEY `id_adres` (`id_adres`);

--
-- Indeksy dla tabeli `kontakt`
--
ALTER TABLE `kontakt`
  ADD PRIMARY KEY (`id_kontakt`);

--
-- Indeksy dla tabeli `konto`
--
ALTER TABLE `konto`
  ADD PRIMARY KEY (`id_konta`),
  ADD KEY `id_klient` (`id_klient`);

--
-- Indeksy dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`id_pracownik`),
  ADD KEY `id_adres_2` (`id_adres_2`);

--
-- Indeksy dla tabeli `transakcja`
--
ALTER TABLE `transakcja`
  ADD PRIMARY KEY (`id_transakcja`),
  ADD KEY `id_nadawca_konto` (`id_nadawca_konto`),
  ADD KEY `id_odbiorca_konto` (`id_odbiorca_konto`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `adres`
--
ALTER TABLE `adres`
  MODIFY `id_adres` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `adres_2`
--
ALTER TABLE `adres_2`
  MODIFY `id_adres_2` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `klient`
--
ALTER TABLE `klient`
  MODIFY `id_klient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `kontakt`
--
ALTER TABLE `kontakt`
  MODIFY `id_kontakt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `konto`
--
ALTER TABLE `konto`
  MODIFY `id_konta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  MODIFY `id_pracownik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `transakcja`
--
ALTER TABLE `transakcja`
  MODIFY `id_transakcja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD CONSTRAINT `klient_ibfk_1` FOREIGN KEY (`id_kontakt`) REFERENCES `kontakt` (`id_kontakt`) ON DELETE CASCADE,
  ADD CONSTRAINT `klient_ibfk_2` FOREIGN KEY (`id_adres`) REFERENCES `adres` (`id_adres`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `konto`
--
ALTER TABLE `konto`
  ADD CONSTRAINT `konto_ibfk_1` FOREIGN KEY (`id_klient`) REFERENCES `klient` (`id_klient`);

--
-- Ograniczenia dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD CONSTRAINT `pracownik_ibfk_1` FOREIGN KEY (`id_adres_2`) REFERENCES `adres_2` (`id_adres_2`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `transakcja`
--
ALTER TABLE `transakcja`
  ADD CONSTRAINT `transakcja_ibfk_1` FOREIGN KEY (`id_nadawca_konto`) REFERENCES `konto` (`id_konta`),
  ADD CONSTRAINT `transakcja_ibfk_2` FOREIGN KEY (`id_odbiorca_konto`) REFERENCES `konto` (`id_konta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
