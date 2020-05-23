package aiss.api.model.utils;

public class AlphanumericSequence {
	
	private Integer sequenceIndex;
	private String alphabet;
	
	public AlphanumericSequence(Integer sequenceIndex, String alphabet) {
		super();
		this.sequenceIndex = sequenceIndex;
		this.alphabet = alphabet;
	}
	
	public AlphanumericSequence() {
		/*By default,
		 * alphabet of 31 characters
		 * sequenceIndex for it be an alphanumeric sequence of 5 characters*/
		this.alphabet = "d95q6v4etkf7pwbcyhjx2mun8garz3s";
		Integer offset = alphabet.length()^3;
		this.sequenceIndex = alphabet.length()^4 + offset;
	}
	
	public AlphanumericSequence(Integer stringLenght) {
		/*By default,
		 * alphabet of 31 characters
		 * sequenceIndex for it be an alphanumeric sequence of 5 characters*/
		this.alphabet = "d95q6v4etkf7pwbcyhjx2mun8garz3s";
		if(1 < stringLenght) {
			Integer offset = (int) Math.pow(alphabet.length(), 0.5 + stringLenght-2);
			this.sequenceIndex = (int) Math.pow(alphabet.length(), stringLenght-1) + offset;
		}else {
			this.sequenceIndex = 0;
		}
	}
	
	public Integer getSequenceIndex() {
		return sequenceIndex;
	}
	public String getAlphabet() {
		return alphabet;
	}
	
	public String next() {
		  long numericalValue = getSequenceIndex();

		  // Initializing Euclidean algorithm
		  long wholeNum = 0;
		  int remainder = 0;
		  String res = "";

		  // The value we'll use as our modulo
		  int modVal = getAlphabet().length();

		  // Loop until while numerical value is not zero
		  while (numericalValue != 0) {

			  
		    wholeNum = (long) Math.floor(numericalValue / modVal);
		    remainder = (int) numericalValue % modVal;

		    res += getAlphabet().charAt(remainder);

		    numericalValue = wholeNum;
		    // Loop again until the wholeNum is zero
		  }
		  this.sequenceIndex++;

		  return new StringBuilder(res).reverse().toString();
		}

}
