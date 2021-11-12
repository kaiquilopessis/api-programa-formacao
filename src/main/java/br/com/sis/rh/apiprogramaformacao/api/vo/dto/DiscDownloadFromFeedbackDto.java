package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;

public class DiscDownloadFromFeedbackDto {

	private byte[] disc;

	public DiscDownloadFromFeedbackDto(FeedBack feedBack) {
		this.disc = feedBack.getDisc();
	}

	public byte[] getDisc() {
		return disc;
	}

	public void setDisc(byte[] disc) {
		this.disc = disc;
	}

	public static List<DiscDownloadFromFeedbackDto> converter(List<FeedBack> feedBacks) {
		return feedBacks.stream().map(DiscDownloadFromFeedbackDto::new).collect(Collectors.toList());
	}

}
