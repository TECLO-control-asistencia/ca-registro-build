package mx.com.teclo.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.teclo.base.vo.SolicitudLecturaVO;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	private RestClient restClient;

	@Override
	public SolicitudLecturaVO getUltimaSolicitud(Long idLector) {
		return restClient.getUltimaSolicitud(idLector);
	}

}
