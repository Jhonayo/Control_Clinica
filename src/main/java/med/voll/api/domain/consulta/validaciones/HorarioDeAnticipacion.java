package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements  ValidadorDeConsultas{

    public void validar(DatosAgendarConsulta datos) {

        var MomentoActual = LocalDateTime.now();
        var horaDeConsulta = datos.fecha();

        var diferenciaMinimaHora = Duration.between(MomentoActual, horaDeConsulta).toMinutes() < 30;
        if (diferenciaMinimaHora) {
            throw new ValidationException("La consulta debe ser agendada con minimo 30 minutos de antelación");
        }

    }
}
