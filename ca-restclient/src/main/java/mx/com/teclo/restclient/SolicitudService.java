package mx.com.teclo.restclient;

import mx.com.teclo.base.vo.SolicitudLecturaVO;

public interface SolicitudService {
	SolicitudLecturaVO getUltimaSolicitud(Long idLector);

}
