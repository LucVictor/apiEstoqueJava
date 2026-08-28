package com.caico.estoque.utils.Conferencia;

import com.caico.estoque.dto.conferencia.IntervaloDatasDTO;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class PeriodoUtils {

    public static IntervaloDatasDTO obterIntervaloSextaAQuinta(int semanasAtras) {

        LocalDate hoje = LocalDate.now();

        LocalDate ultimaSexta = hoje
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY))
                .minusWeeks(1 + semanasAtras);

        LocalDate ultimaQuinta = ultimaSexta.plusDays(6);

        return new IntervaloDatasDTO(
                ultimaSexta,
                ultimaQuinta
        );
    }

    public static IntervaloDatasDTO obterIntervaloSextaAQuinta() {
        return obterIntervaloSextaAQuinta(0);
    }
}