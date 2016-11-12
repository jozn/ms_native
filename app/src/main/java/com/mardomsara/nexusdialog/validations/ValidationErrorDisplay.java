package com.mardomsara.nexusdialog.validations;

import java.util.List;

/**
 * Defines methods to display the validation errors.
 */
public interface ValidationErrorDisplay {
    /**
     * Display the validation errors.
     *
     * @param errors The errors to show.
     */
    void showErrors(List<ValidationError> errors);

    /**
     * Dismiss the validation errors.
     */
    void resetErrors();
}
