package seedu.siasa.storage;

import static seedu.siasa.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.siasa.commons.exceptions.IllegalValueException;
import seedu.siasa.commons.util.JsonUtil;

public class JsonSerializableSiasaTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableSiasaTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsSiasa.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonSiasa.json");
    private static final Path INVALID_POLICY_FILE = TEST_DATA_FOLDER.resolve("invalidPolicySiasa.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonSiasa.json");
    private static final Path DUPLICATE_POLICY_FILE = TEST_DATA_FOLDER.resolve("duplicatePolicySiasa.json");

    /*  TODO: Fix test case
    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableSiasa dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableSiasa.class).get();
        Siasa siasaFromFile = dataFromFile.toModelType();
        Siasa typicalPersonsSiasa = TypicalSiasa.getTypicalSiasa();
        assertEquals(siasaFromFile, typicalPersonsSiasa);
    }
     */

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableSiasa dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
            JsonSerializableSiasa.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_invalidPolicyFile_throwsIllegalValueException() throws Exception {
        JsonSerializableSiasa dataFromFile = JsonUtil.readJsonFile(INVALID_POLICY_FILE,
            JsonSerializableSiasa.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableSiasa dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
            JsonSerializableSiasa.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableSiasa.MESSAGE_DUPLICATE_PERSON,
            dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePolicies_throwsIllegalValueException() throws Exception {
        JsonSerializableSiasa dataFromFile = JsonUtil.readJsonFile(DUPLICATE_POLICY_FILE,
            JsonSerializableSiasa.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableSiasa.MESSAGE_DUPLICATE_POLICY,
            dataFromFile::toModelType);
    }

}
