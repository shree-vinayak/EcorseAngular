import { AbstractControl } from "@angular/forms";

export function validatepassord(control: AbstractControl): { [key: string]: any } | null {

    const passsord = control.get('password');
    const confirmpassword = control.get('confirmpassword');

    if(passsord.pristine || confirmpassword.pristine)
    {
        return null; 
    }
 
    if (passsord && confirmpassword && passsord.value != confirmpassword.value) {
        return { 'misMatch': true };
    }

    return null;
}