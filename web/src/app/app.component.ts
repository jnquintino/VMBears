import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {UploadService} from "./services/upload.service";
import {BlockUI, NgBlockUI} from "ng-block-ui";

@Component({
  selector: 'qs-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  // @ts-ignore
  @BlockUI() blockUI: NgBlockUI;
  title = 'VMBears';
  // @ts-ignore
  form: FormGroup;
  files: string[] = [];
  myFiles: File[] = [];

  constructor(private formBuilder: FormBuilder, private uploadService: UploadService) {}

  ngOnInit(): void {
    this.createForm();
  }

  private createForm() {
    this.form = this.formBuilder.group({
      num: new FormControl()
    });
  }

  upload() {
    this.blockUI.start('Enviando o(s) arquivo(s)...');
    for (let i = 0; i < this.myFiles.length; i++) {
      this.uploadService.upload(this.myFiles[i]).subscribe(() => {
        this.reset();
        this.blockUI.stop();
      })
    }
  }

  details(event: Event) {
    if (event && event.target && (<HTMLInputElement> event.target).files) {
      const array = (<HTMLInputElement> event.target).files;
      if (array) {
        for (let i = 0; i < array.length; i++) {
          this.files.push(array[i].name);
          this.myFiles.push(array[i]);
        }
      }
    }
  }

  reset() {
    this.files = [];
    this.myFiles = [];
  }
}
