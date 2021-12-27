package aopGuitarXML;

public class Instrumentalist implements Performer{

	private Instrument instrument;
	
	public Instrument getInstrument() {
		return instrument;
	}
	
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public void perform(String str) throws PerformanceExceoption {
		if("Good".equals(str)) {
			instrument.play();
		}else {
			throw new PerformanceExceoption();
		}
	}
	
}
