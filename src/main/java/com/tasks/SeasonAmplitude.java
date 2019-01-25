package com.tasks;

public class SeasonAmplitude {
	public static String maxSeasonAmplitude(int[] T) {
		int maxAmplitude = Integer.MIN_VALUE;
		String season = null;
		// length in days for each season
		int seasonLength = T.length / 4;
		for (int i = 0; i <= 3; i++) {
			int minTemp = Integer.MAX_VALUE;
			int maxTemp = Integer.MIN_VALUE;
			for (int j = 0; j < seasonLength; j++) {
				int index = seasonLength * i + j;
				int currentValue = T[index];
				if (currentValue > maxTemp) {
					maxTemp = currentValue;
				}
				if (currentValue < minTemp) {
					minTemp = currentValue;
				}
			}
			int tempAmplitude = Math.abs(maxTemp - minTemp);
			if (tempAmplitude > maxAmplitude) {
				maxAmplitude = tempAmplitude;
				season = getSeason(i);
			}
		}
		return season;
	}

	public static String getSeason(int season) {
		switch (season) {
		case 0:
			return "WINTER";
		case 1:
			return "SPRING";
		case 2:
			return "SUMMER";
		case 3:
			return "AUTUMN";
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(maxSeasonAmplitude(new int[] {1,2,3,4,5,6,7,8}));
	}
}
