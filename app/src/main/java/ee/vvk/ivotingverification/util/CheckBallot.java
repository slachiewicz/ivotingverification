package ee.vvk.ivotingverification.util;

import ee.vvk.ivotingverification.model.Candidate;

public class CheckBallot {

    private static final String TAG = CheckBallot.class.getSimpleName();

    public static boolean wrongCandidateNumber(String decryptedChoice) {
        Candidate candidate = new Candidate(decryptedChoice);
        if (!RegexMatcher.IsCandidateNumber(candidate.number)) {
            Util.logDebug(TAG, "Wrong candidate number");
            return true;
        }
        return false;
    }

    public static boolean wrongCandidateName(String decryptedChoice) {
        Candidate candidate = new Candidate(decryptedChoice);
        if (!RegexMatcher.IsLessThan101UtfChars(candidate.name)) {
            Util.logDebug(TAG, "Wrong candidate name");
            return true;
        }
        return false;
    }

    public static boolean decryptedChoiceNotInCandidateList(String decryptedChoice) {
        if (!C.candidateList.contains(decryptedChoice)) {
            Util.logDebug(TAG, "Ballot not in election list");
            return true;
        }
        return false;
    }
}
