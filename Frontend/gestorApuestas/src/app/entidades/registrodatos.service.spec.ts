import { TestBed } from '@angular/core/testing';

import { RegistrodatosService } from './registrodatos';

describe('RegistrodatosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegistrodatosService = TestBed.get(RegistrodatosService);
    expect(service).toBeTruthy();
  });
});
